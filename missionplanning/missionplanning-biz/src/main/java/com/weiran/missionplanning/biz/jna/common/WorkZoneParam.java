package com.weiran.missionplanning.biz.jna.common;


/**
 * discription:测区参数
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/13 9:48
 */
public class WorkZoneParam {
    /*=============测区基本参数=============*/

    /**
     * 基准面高程
     */
    public double getDatumElevation(double datumElevation) {
        if (Double.isNaN(datumElevation) || datumElevation == -1 || datumElevation == -21121) {
            datumElevation = 446.80851063829795;
            return datumElevation;
        } else {
            return datumElevation;
        }
    }

    /**
     * 缓冲距离
     */
    public double getBufferDistance(double bufferDistance) {
        if (Double.isNaN(bufferDistance) || bufferDistance == -1 || bufferDistance == -21121) {
            bufferDistance = 100;
            return bufferDistance;
        } else {
            return bufferDistance;
        }
    }

    /**
     * 进入角度
     */
    public double getEnterAngle(double enterAngle) {
        if (Double.isNaN(enterAngle) || enterAngle == -1 || enterAngle == -21121) {
            enterAngle = 89.95388513041851;
            return enterAngle;
        } else {
            return enterAngle;
        }
    }

    /**
     * 航向重叠度
     */
    public double getCourseOverlap(double courseOverlap) {
        if (Double.isNaN(courseOverlap) || courseOverlap == -1 || courseOverlap == -21121) {
            courseOverlap = 0.7;
            return courseOverlap;
        } else {
            courseOverlap = Math.round(courseOverlap) / 100.0;
            return courseOverlap;
        }
    }

    /**
     * 旁向重叠度
     */
    public double getLateralOverlap(double lateralOverlap) {
        if (Double.isNaN(lateralOverlap) || lateralOverlap == -1 || lateralOverlap == -21121) {
            lateralOverlap = 0.65;
            return lateralOverlap;
        } else {
            lateralOverlap = Math.round(lateralOverlap) / 100.0;
            return lateralOverlap;
        }
    }

    /**
     * 进入点
     */
    public int getEnterPointsValue(int enterPointsValue) {
        if (enterPointsValue == -1 || enterPointsValue == -21121) {
            enterPointsValue = 0;
            return enterPointsValue;
        } else {
            return enterPointsValue;
        }
    }


    /*==========相机参数==========*/

    /**
     * 焦距
     */
    public double getFocalLength(double focalLength) {
        if (Double.isNaN(focalLength) || focalLength == -1 || focalLength == -21121) {
            focalLength = 12;
            return focalLength;
        } else {
            return focalLength;
        }
    }

    /**
     * 架构倍数
     */
    public int getFrameworkMultiple(int frameworkMultiple) {
        if (frameworkMultiple == -1 || frameworkMultiple == -21121) {
            frameworkMultiple = 2;
            return frameworkMultiple;
        } else {
            return frameworkMultiple;
        }
    }

    /**
     * 架构对数
     */
    public int getFrameworkLogarithm(int frameworkLogarithm) {
        if (frameworkLogarithm == -1 || frameworkLogarithm == -21121) {
            frameworkLogarithm = 1;
            return frameworkLogarithm;
        } else {
            return frameworkLogarithm;
        }
    }

    /**
     * 架构高差
     */
    public double getAltitudeDifference(double altitudeDifference) {
        if (Double.isNaN(altitudeDifference) || altitudeDifference == -1 || altitudeDifference == -21121) {
            altitudeDifference = 50;
            return altitudeDifference;
        } else {
            return altitudeDifference;
        }
    }

    /**
     * 目标分辨率
     */
    public double getResolutionRatioCamera(double resolutionRatioCamera) {
        if (Double.isNaN(resolutionRatioCamera) || resolutionRatioCamera == -1 || resolutionRatioCamera == -21121) {
            resolutionRatioCamera = 0.05;
            return resolutionRatioCamera;
        } else {
            return resolutionRatioCamera;
        }
    }


    /**
     * 相对航高
     */
    public double getFlightHeight_load(double flightHeight_load) {
        if (Double.isNaN(flightHeight_load) || flightHeight_load == -1 || flightHeight_load == -21121) {
            flightHeight_load = 10;
            return flightHeight_load;
        } else {
            return flightHeight_load;
        }
    }
}
