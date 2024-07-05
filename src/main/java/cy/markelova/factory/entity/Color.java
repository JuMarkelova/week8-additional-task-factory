package cy.markelova.factory.entity;

public enum Color {
    WHITE, BLACK, GREY, BROWN;

    public static Color getRandomColor(int number) {
        Color color = null;
        if (number >= 0 && number < 31) {
            color = WHITE;
        } else if (number >= 31 && number < 61) {
            color = BLACK;
        } else if (number >= 61 && number < 81) {
            color = GREY;
        } else if (number >= 81 && number < 100) {
            color = BROWN;
        }
        return color;
    }
}