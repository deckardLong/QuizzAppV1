package com.nhgl.utils.themes;

import javafx.scene.Scene;

public class ThemeManager {
    private static ThemeFactory themeFactory = new DefaultThemeFactory();

    public static void setThemeFactory(ThemeFactory themeFactory) {
        ThemeManager.themeFactory = themeFactory;
    }

    public static void applyTheme(Scene scene) {
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(themeFactory.getStyleSheet());
    }
}
