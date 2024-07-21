# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Glide
# Keep the classes for Glide's generated API
-keep class com.bumptech.glide.** { *; }
-keep interface com.bumptech.glide.** { *; }
-keep class * extends com.bumptech.glide.module.AppGlideModule
-keep class * extends com.bumptech.glide.module.LibraryGlideModule
-keep class * extends com.bumptech.glide.module.GlideModule

# Glide - annotations and reflection used by Glide
-keep public class * extends com.bumptech.glide.request.RequestOptions
-keep public class * extends com.bumptech.glide.request.BaseRequestOptions
-keep public class * extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation
-keep public class * extends com.bumptech.glide.load.engine.Resource
-keep public class * extends com.bumptech.glide.manager.LifecycleListener

# AndroidX Core
# Generally, no specific rules are needed for AndroidX Core library

# AndroidX AppCompat
# Generally, no specific rules are needed for AndroidX AppCompat library

# Material Components
# Generally, no specific rules are needed for Material Components library

# JUnit
# JUnit is used only in the test scope, so no ProGuard rules are needed

# AndroidX JUnit
# Generally, no specific rules are needed for AndroidX JUnit library

# AndroidX Espresso
# Generally, no specific rules are needed for AndroidX Espresso library

# Annotations Processor for Glide
-keep class com.bumptech.glide.annotation.compiler.** { *; }
-keep class com.bumptech.glide.annotation.** { *; }
