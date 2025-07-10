package com.nhgl.utils.themes;

import com.nhgl.quizzappv1.App;

public class DarkThemeFactory implements ThemeFactory {
    @Override
    public String getStyleSheet() {
        return App.class.getResource("dark.css").toExternalForm();
    }  
}
