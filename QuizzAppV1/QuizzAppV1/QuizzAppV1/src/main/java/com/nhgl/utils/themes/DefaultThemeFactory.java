package com.nhgl.utils.themes;

import com.nhgl.quizzappv1.App;

public class DefaultThemeFactory implements ThemeFactory {
    @Override
    public String getStyleSheet() {
       return App.class.getResource("style.css").toExternalForm();
    }
}
