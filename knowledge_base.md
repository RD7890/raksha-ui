# Raksha UI Knowledge Base

## Device: Zone Alpha S9 Ultra / Shenzhen Yuexin S9 Ultra
- **OS:** Android 8.1
- **Hardware:** Typically Quad-core SL8541E, 4GB/8GB RAM.
- **Display:** Small smartwatch screen, ~2.02 inches, typically 320x386.
- **Features:** Touchscreen, 4G, Bluetooth, Wi-Fi. It's basically a small Android phone.
- **Constraints:** Low RAM, low CPU/GPU, low battery capacity. Needs aggressive optimization. 
  - Keep background processes minimal.
  - Animations must be lightweight (no expensive blurs or physics).

## Launcher (Home) App on Android 8 (API 26)
- **Role:** Replaces the system launcher.
- **Intent Filter:** Needs `<category android:name="android.intent.category.HOME" />` and `<category android:name="android.intent.category.DEFAULT" />`.
- **App Discovery:** Use `PackageManager` to query intents with action `Intent.ACTION_MAIN` and category `Intent.CATEGORY_LAUNCHER`.
- **AppWidget Support:** Supported via `AppWidgetHost`. We can host widgets, but since the screen is small, we should design it carefully.
- **Gestures:** Implement standard gesture detection (Swipe up/down/left/right) on the root view.
- **Design:** Flat premium colors, specifically `#FF4A6B`. NO GRADIENTS. Watch-style UI.

## Nova Launcher Reference
- **Concept:** Nova is highly customizable, focusing on a clean app drawer, grid-based home screens, folders, and smooth transitions.
- **How it works:** 
  - Home screen is a paginated layout (ViewPager or RecyclerView).
  - App drawer is usually a GridView/RecyclerView holding all installed applications.
  - Shortcut and widget management is done via persistent storage.
  - Gestures are deeply integrated for quick actions.
- **For S9 Ultra:** We will adapt this concept for a small, round/square screen, focusing on vertical scrolling and large touch targets, while keeping it flat and premium.

## Action Plan
1. Create a standard Android Gradle project in Kotlin/Java.
2. Implement `MainActivity` as the Home Launcher.
3. Fetch installed apps via `PackageManager`.
4. Build a UI with a Watch Face (clock/date) and an App Drawer (grid).
5. Implement gesture detection.
6. Push via GitHub Actions and release.
