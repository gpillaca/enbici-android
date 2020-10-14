# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/willy/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-dontshrink
-dontoptimize

-optimizationpasses 5
-repackageclasses

-dontusemixedcaseclassnames
-allowaccessmodification
-optimizations !code/simplification/arithmetic
-keepattributes *Annotation*
-dontskipnonpubliclibraryclasses
-dontpreverify
-renamesourcefileattribute SourceFile
-verbose

-printseeds seeds.txt
-printusage unused.txt

-ignorewarnings
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keepclassmembers class fqcn.of.javascript.interface.for.webview {
  public *;
}

# http://proguard.sourceforge.net/manual/attributes.html
-keepattributes SourceFile,LineNumberTable # for crashlytics
-keepattributes Signature,*Annotation* # common for most libraries
-keepattributes RuntimeVisibleAnnotations
-keepattributes EnclosingMethod

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.content.pm.PackageManager
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclassmembers class ** {
    public void onEvent(**);
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keep class com.google.** { *; }
-keep interface android.support.** { *; }
-keep class android.support.** { *; }
-keep interface android.support.v7.** { *; }
-keep class android.support.v7.** { *; }
-keep class com.android.** { *; }
-keep interface com.android.** { *; }
-keep class kotlin.Metadata { *; }

-dontwarn javax.annotation.**
-dontwarn javax.inject.**
-dontwarn com.google.**
-dontwarn sun.misc.Unsafe
-dontwarn kotlin.**
-dontwarn org.jetbrains.annotations.**

-keepclassmembers class * {
    private <fields>;
    private <methods>;
}

-keep class pe.gob.msb.gp.enbici.

# Crashlytics
-libraryjars libs
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**
-keep public class * extends java.lang.Exception

# Jackson 2.x (fasterxml package instead of codehaus package)
-keep class com.fasterxml.jackson.databind.ObjectMapper {
    public <methods>;
    protected <methods>;
}
-keep class com.fasterxml.jackson.databind.ObjectWriter {
    public ** writeValueAsString(**);
}
-keepnames class com.fasterxml.jackson.** { *; }
-dontwarn com.fasterxml.jackson.databind.**

##------ Firebase ------
-dontwarn com.firebase.ui.auth.data.remote.**
-keep public class com.google.firebase.iid.FirebaseInstanceId {
    public *;
}
##-----------

##------ Timber ------
-dontwarn org.jetbrains.annotations.**
##------------

##------ Gson ------
-keep class sun.misc.Unsafe { *; }
# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
##-------------

##------- HTTPClient ----
-dontwarn org.apache.commons.**
-keep class org.apache.http.** { *; }
-dontwarn org.apache.http.**

# Classes get rejected without this when running the app if the app has been run through ProGuard
-keepattributes InnerClasses,EnclosingMethod

-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** d(...);
    public static *** e(...);
}