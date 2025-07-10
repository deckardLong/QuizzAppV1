package com.nhgl.utils.themes;

import com.nhgl.quizzappv1.App;

public class LightThemeFactory implements ThemeFactory {
    @Override
    public String getStyleSheet() {
        return App.class.getResource("light.css").toExternalForm();
    }
}
