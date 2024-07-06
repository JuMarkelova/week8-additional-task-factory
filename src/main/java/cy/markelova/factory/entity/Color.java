package cy.markelova.factory.entity;

public enum Color {

    WHITE(1), BLACK(2), GREY(3), BROWN(4);

    int colorIndex = 0;

    Color(int index) {
        this.colorIndex = index;
    }

    public int getColorIndex() {
        return colorIndex;
    }

    public static Color getColorByIndex(int index) {
        return Color.values()[index - 1];
    }

    public static Color getRandomColor() {
        return Color.getColorByIndex((int) (Math.random() * 4) + 1);
    }
}