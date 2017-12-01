package image;

public class Image {
    private byte[] bytes;

    public Image(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public boolean equals(Object obj) {
        Image img = (Image) obj;
        if (this.bytes.length != img.bytes.length) {
            return false;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != img.bytes[i]) {
                return false;
            }
        }
        return true;
    }
}
