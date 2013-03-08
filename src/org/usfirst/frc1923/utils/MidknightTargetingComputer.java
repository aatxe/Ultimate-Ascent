package org.usfirst.frc1923.utils;

import java.util.Vector;

import org.usfirst.frc1923.Components;

import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 * A powerful targeting computer built using NI Vision.
 * 
 * @author Aaron Weiss, Aravind Koneru, Pavan Hegde, Olu Olorode
 * @version 2.0
 * @since 2/14/13
 */
public class MidknightTargetingComputer {
	private static Vector targets = new Vector();
	private static int redLow = 0, redHigh = 80;
	private static int greenLow = 110, greenHigh = 205;
	private static int blueLow = 55, blueHigh = 220;
	private static final double areaThreshold = 444;
	private static final double rectangularityThreshold = 70;
	private static final double aspectThreshold = 0;

	/**
	 * Updates the image to use with the targeting computer.
	 * 
	 * @param image
	 * 				the new image to work with
	 */
	public static void update(ColorImage image) {
		BinaryImage masked, hulled, filtered;
		ParticleAnalysisReport[] all;
		targets.removeAllElements();
		try {
			masked = image.thresholdRGB(redLow, redHigh, greenLow, greenHigh, blueLow, blueHigh);
			hulled = masked.convexHull(true);
			filtered = hulled.removeSmallObjects(true, 2);
			all = filtered.getOrderedParticleAnalysisReports(10);
			image.free();
			filtered.free();
			hulled.free();
			masked.free();
			for (int i = 0; i < all.length; i++) {
				if (all[i].particleArea > areaThreshold) {
					double rectangularityScore = rectangularityScore(all[i].particleArea, all[i].boundingRectWidth, all[i].boundingRectHeight);
					double aspectRatioScore = aspectRatioScore(all[i].boundingRectWidth, all[i].boundingRectHeight);
					if (rectangularityScore > rectangularityThreshold && aspectRatioScore > aspectThreshold) {
						targets.addElement(new Target(all[i].center_mass_x, all[i].center_mass_y, all[i].imageWidth, all[i].imageHeight));
					}
				}
			}
		} catch (NIVisionException e) {
			System.out.println("TargetFinder:: Failed to update()");
			e.printStackTrace();
		}
		System.out.println("Found " + targets.size() + " targets.");
	}
	
	/**
	 * Calculates the angle needed to turn for aiming.
	 * 
	 * @return the angle to turn
	 */
	public static double getTurnAngle() {
		int width = Components.camera.getResolution().width;
		double alpha = 47; // alpha - camera viewing angle
		Target[] targets = MidknightTargetingComputer.getTargets();
		int closestIndex = 0;
		for (int i = 1; i < targets.length; i++) {
			if (Math.abs(targets[i].x - (width / 2)) < Math.abs(targets[closestIndex].x - (width / 2)))
				closestIndex = i;
		}
		return alpha * ((targets[closestIndex].x - (width / 2)) / width);
	}

	/**
	 * Calculates a score for the rectangularity of the particle mass.
	 * 
	 * @param area
	 * 				the area of the particle mass
	 * @param width
	 * 				the width of the particle mass
	 * @param height
	 * 				the height of the particle mass
	 * @return rectangularity score
	 */
	private static double rectangularityScore(double area, double width, double height) {
		double rectangularityScore = area;
		rectangularityScore /= width;
		rectangularityScore /= height;
		rectangularityScore *= 100;
		return rectangularityScore;
	}

	/**
	 * Calculates a score for the aspect ratio of the particle mass.
	 * 
	 * @param width
	 * 				the width of the particle mass
	 * @param height
	 * 				the height of the particle mass
	 * @return aspect ratio score
	 */
	private static double aspectRatioScore(double width, double height) {
		double aspectRatioScore = width / height;
		aspectRatioScore /= 1.33;
		aspectRatioScore = Math.abs(1.0 - aspectRatioScore);
		aspectRatioScore = 100.0 * (1.0 - aspectRatioScore);
		if (aspectRatioScore > 100) {
			aspectRatioScore = 100;
		} else if (aspectRatioScore < 0) {
			aspectRatioScore = 0;
		}
		return aspectRatioScore;
	}
	
	/**
	 * Gets an array of all the calculated targets.
	 * @return all the targets
	 */
	public static Target[] getTargets() {
		Target[] ret = new Target[targets.size()];
		for (int i = 0; i < targets.size(); i++)
			ret[i] = (Target) targets.elementAt(i);
		return ret;
	}
	
	/**
	 * Gets the target at the desired index.
	 * @param index
	 * 				the index of the target
	 * @return the target at the index
	 */
	public static Target getTarget(int index) {
		return (Target) targets.elementAt(index);
	}
}
