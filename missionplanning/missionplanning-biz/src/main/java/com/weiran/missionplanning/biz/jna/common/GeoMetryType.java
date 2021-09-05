package com.weiran.missionplanning.biz.jna.common;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/7/5 0005 15:51
 */
public class GeoMetryType {

    /**< unknown type; non-standard */
    public static int FGT_UNKNOWN = 0;
    /**< 0-dimensional geometric object; standard  */
    public static int FGT_POINT = 1;
    /**< 1-dimensional geometric object with linear
     *   interpolation between Points; standard  */
    public static int FGT_LINE_STRING = 2;
    /**< planar 2-dimensional geometric object defined
     *   by 1 exterior boundary and 0 or more interior
     *   boundaries; standard  */
    public static int FGT_POLYGON = 3;
    /**< GeometryCollection of Points; standard  */
    public static int FGT_MULTI_POINT = 4;
    /**< GeometryCollection of LINE_STRINGs; standard  */
    public static int FGT_MULTI_LINE_STRING = 5;
    /**< GeometryCollection of Polygons; standard  */
    public static int FGT_MULTI_POLYGON = 6;
    /**< geometric object that is a collection of 1
     *   or more geometric objects; standard  */
    public static int FGT_GEOMETRY_COLLECTION = 7;
    /**< one or more circular arc segments connected end to end;
     *   ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_CIRCULAR_STRING = 8;
    /**< sequence of contiguous curves; ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_COMPOUND_CURVE = 9;
    /**< planar surface; defined by 1 exterior boundary
     *   and zero or more interior boundaries; that are curves.
     *    ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_CURVE_POLYGON = 10;
    /**< GeometryCollection of Curves; ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_MULTI_CURVE = 11;
    /**< GeometryCollection of Surfaces; ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_MULTI_SURFACE = 12;
    /**< Curve (abstract type). ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CURVE = 13;
    /**< Surface (abstract type). ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_SURFACE = 14;
    /**< a contiguous collection of polygons; which share common boundary segments;
     *   ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_POLYHEDRAL_SURFACE = 15;
    /**< a PolyhedralSurface consisting only of Triangle patches
     *    ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TIN = 16;
    /**< a Triangle. ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TRIANGLE = 17;
    /**< non-standard; for pure attribute records */
    public static int FGT_NONE = 100;
    /**< non-standard; just for createGeometry() */
    public static int FGT_LINEAR_RING = 101;
    /**< FGT_CircularString with Z component. ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_CIRCULAR_STRING_Z = 1008;
    /**< FGT_CompoundCurve with Z component. ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_COMPOUND_CURVE_Z = 1009;
    /**< FGT_CurvePolygon with Z component. ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_CURVE_POLYGON_Z = 1010;
    /**< FGT_MULTI_Curve with Z component. ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_MULTI_CURVE_Z = 1011;
    /**< FGT_MULTI_Surface with Z component. ISO SQL/MM Part 3. GDAL &gt;= 2.0 */
    public static int FGT_MULTI_SURFACE_Z = 1012;
    /**< FGT_Curve with Z component. ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CURVE_Z = 1013;
    /**< FGT_Surface with Z component. ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_SURFACE_Z = 1014;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_POLYHEDRAL_SURFACE_Z = 1015;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TIN_Z = 1016;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TRIANGLE_Z = 1017;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_POINT_M = 2001;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_LINE_STRING_M = 2002;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_POLYGON_M = 2003;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_POINT_M = 2004;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_LINE_STRING_M = 2005;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_POLYGON_M = 2006;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_GEOMETRY_COLLECTION_M = 2007;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CIRCULAR_STRING_M = 2008;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_COMPOUND_CURVE_M = 2009;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CURVE_POLYGON_M = 2010;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_CURVE_M = 2011;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_SURFACE_M = 2012;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CURVE_M = 2013;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_SURFACE_M = 2014;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_POLYHEDRAL_SURFACE_M = 2015;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TIN_M = 2016;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TRIANGLE_M = 2017;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_POINT_ZM = 3001;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_LINE_STRING_ZM = 3002;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_POLYGON_ZM = 3003;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_POINT_ZM = 3004;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_LINE_STRING_ZM = 3005;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_POLYGON_ZM = 3006;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_GEOMETRY_COLLECTION_ZM = 3007;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CIRCULAR_STRING_ZM = 3008;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_COMPOUND_CURVE_ZM = 3009;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CURVE_POLYGON_ZM = 3010;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_CURVE_ZM = 3011;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_MULTI_SURFACE_ZM = 3012;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_CURVE_ZM = 3013;
    /**< ISO SQL/MM Part 3. GDAL &gt;= 2.1 */
    public static int FGT_SURFACE_ZM = 3014;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_POLYHEDRAL_SURFACE_ZM = 3015;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TIN_ZM = 3016;
    /**< ISO SQL/MM Part 3. Reserved in GDAL &gt;= 2.1 but not yet implemented */
    public static int FGT_TRIANGLE_ZM = 3017;
    /**< 2.5D extension as per 99-402 for KML/KMZ */
    public static int FGT_POINT_25D = 0x80000001;
    /**< 2.5D extension as per 99-402 for KML/KMZ */
    public static int FGT_LINE_STRING_25D = 0x80000002;
    /**< 2.5D extension as per 99-402 for KML/KMZ */
    public static int FGT_POLYGON_25D = 0x80000003;
    /**< 2.5D extension as per 99-402 for KML/KMZ */
    public static int FGT_MULTI_POINT_25D = 0x80000004;
    /**< 2.5D extension as per 99-402 for KML/KMZ */
    public static int FGT_MULTI_LINE_STRING_25D = 0x80000005;
    /**< 2.5D extension as per 99-402 for KML/KMZ */
    public static int FGT_MULTI_POLYGON_25D = 0x80000006;
    /**< 2.5D extension as per 99-402 for KML/KMZ */
    public static int FGT_GEOMETRY_COLLECTION_25D = 0x80000007;
}
