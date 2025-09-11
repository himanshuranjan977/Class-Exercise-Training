class Package<H extends Number, W extends Number, L extends Number> {
    private H height;
    private W width;
    private L length;

    public void setHeight(H height) {
        this.height = height;
    }

    public void setWidth(W width) {
        this.width = width;
    }

    public void setLength(L length) {
        this.length = length;
    }

    public H getHeight() {
        return height;
    }

    public W getWidth() {
        return width;
    }

    public L getLength() {
        return length;
    }

    public double getVolume() {
        return height.doubleValue() * width.doubleValue() * length.doubleValue();
    }
}