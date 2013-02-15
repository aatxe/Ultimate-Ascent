package org.usfirst.frc1923.utils;

import java.util.Vector;

import com.sun.squawk.util.Arrays;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 * 
 * @author Pavan Hegde, Olu Olorode, many credits to Aaron Weiss
 * @version 1.1
 * @since 2/13/13
 */
public class Targeting {
	private static Vector targets = new Vector();
	private static int redLow = 0;
	private static int redHigh = 80;
	private static int greenLow = 110;
	private static int greenHigh = 205;
	private static int blueLow = 55;
	private static int blueHigh = 220;
	private static ParticleAnalysisReport[] allTwo;
	
	public static final double areaThreshold = 444;
	public static final double rectangularityThreshold = 70;
	public static final double aspectThreshold = 0;
	
	public static double getDistance(double width, double viewingAngle){
		double distance = java.lang.Math.tan((viewingAngle/2));
		distance *= width;
		return distance;
	}
	
	public static double getTurnAngle(double width, double viewingAngle) {
		int[] centroidX = new int[5];
		for(int x = 0; x <= 5; x++) {                  //160
			centroidX[x] = allTwo[x].center_mass_x;
		}
		Arrays.sort(centroidX);

		while (centroidX.length > 1){
			if(centroidX[(centroidX.length/2) -1] > 160){
				if(centroidX.length == 5) {
					int[] a = {centroidX[(centroidX.length/2) - 1], centroidX[(centroidX.length/2) - 2], centroidX[(centroidX.length/2) - 3]};
					centroidX = a;
				}
				if(centroidX.length == 3) {
					int[] a = {centroidX[(centroidX.length/2) - 1], centroidX[(centroidX.length/2) - 2]};
					centroidX = a;
				}
			} else if ((centroidX.length/2) -1 == 160) {
				centroidX[0] = 160;
			} else if ((centroidX.length/2) -1 < 160) {
				if(centroidX.length == 5) {
					int[] a = {centroidX[(centroidX.length/2) - 1], centroidX[(centroidX.length/2)], centroidX[(centroidX.length/2) + 1]};
					centroidX = a;
					}
				if(centroidX.length == 3) {
					int[] a = {centroidX[(centroidX.length/2) - 1], centroidX[(centroidX.length/2) - 0]};
					centroidX = a;
				}
			}
		}
		
		double dNew = java.lang.Math.abs(centroidX[(centroidX.length/2) -1]);
		double turnAngle = viewingAngle * (dNew/320); 
		return turnAngle;
	}
	
	public static double getRectangularity(double area, double width, double height) {
		double rectangularity = area;
		rectangularity /= width;
		rectangularity /= height;
		rectangularity *= 100;
		return rectangularity;
	}
	
	public static double getAspectRatio(double width, double height) {
		double aspectRatio = width/height;
		aspectRatio /= 1.33; 
		aspectRatio = Math.abs(1.0 - aspectRatio);
		aspectRatio = 100.0 * (1.0 - aspectRatio);
		if(aspectRatio > 100) {
			aspectRatio = 100;
		}
		if (aspectRatio < 0) {
			aspectRatio = 0;
		}
		return aspectRatio;
	}
	
	public static void updateImage(ColorImage image) {
		BinaryImage masked;
		BinaryImage hulled;
		BinaryImage filtered;
		ParticleAnalysisReport[] all;
		try {
			masked = image.thresholdRGB(redLow, redHigh, greenLow, greenHigh, blueLow, blueHigh);
			hulled = masked.convexHull(true);
			filtered = hulled.removeSmallObjects(true, 2); 
			all = filtered.getOrderedParticleAnalysisReports(10);
			allTwo = all;
			image.free();
			masked.free();
			hulled.free();
			filtered.free();
			for(int x = 0; x < all.length; x++) {
				if (all[x].particleArea > areaThreshold) {
					double rectangularity = getRectangularity(all[x].particleArea, all[x].boundingRectWidth, all[x].boundingRectHeight);
					double aspectRatio = getAspectRatio(all[x].boundingRectWidth, all[x].boundingRectHeight);
					if (rectangularity > rectangularityThreshold && aspectRatio > aspectThreshold) {
						targets.addElement(all[x]);
					}
				}
			}
		} catch (NIVisionException n) {
			Timer.delay(0.02);
			n.printStackTrace();
		}
	}
	public int getNumberOfTargets() {
		return targets.size();
	}
	public Target[] getTargets() {
		Target[] targets = new Target[this.targets.size()];
		for (int i = 0; i < targets.length; i++) {
			targets[i] = new Target(((ParticleAnalysisReport) this.targets.elementAt(i)).center_mass_x, ((ParticleAnalysisReport) this.targets.elementAt(i)).center_mass_y, ((ParticleAnalysisReport) this.targets.elementAt(i)).boundingRectHeight, ((ParticleAnalysisReport) this.targets.elementAt(i)).boundingRectWidth);
		}
		return targets;
	}

	public Target getTarget(int targetNumber) {
		return new Target(((ParticleAnalysisReport) this.targets.elementAt(targetNumber)).center_mass_x, ((ParticleAnalysisReport) this.targets.elementAt(targetNumber)).center_mass_y);
	}
}