package com.minmusxminmus.lovecraft.content.gui.renderer;

public class OldBookContentRenderer {
    /*
    The idea here is to have a special way to render text on a book. The only inputs should be a specially formatted
    text file, along with the relevant pictures and the book it's being rendered on. The idea is to let this renderer
    decide what text goes in what page, along with the pictures and whatnot. This would all be configurable with the
    aforementioned text file, where you can easily tell the renderer where to add a line break, when to add an image,
    how much space it takes, its position, etc.

    I'm currently not sure if there's incentive to have more than one type of old book renderer. It would only make
    sense with different types of old books, perhaps with broken pages and stuff like that. I don't think it's worth
    the effort, a single renderer that only bases itself on width and size of pages is probably good enough.

    For this renderer to work I have to investigate the existing renderer, the fontRenderer inside the GUI screen
    object.
     */
}
