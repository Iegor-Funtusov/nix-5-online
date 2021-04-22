package ua.com.alevel;

public class ConvertUtil {

    public static String convertNumberToBinary(Number value, Class<? extends Number> number) {

        if (number.isAssignableFrom(Byte.class)) {
            return String.format("%8s", Integer.toBinaryString(value.byteValue() & 0xFF)).replace(' ', '0');
        }

        if (number.isAssignableFrom(Short.class)) {
            return String.format("%16s", Integer.toBinaryString(value.shortValue() & 0xFFFF)).replace(' ', '0');
        }
        if (number.isAssignableFrom(Integer.class)) {
            return String.format("%32s", Integer.toBinaryString(value.intValue())).replace(' ', '0');
        }
        if (number.isAssignableFrom(Long.class)) {
            return String.format("%64s", Long.toBinaryString(value.longValue())).replace(' ', '0');
        }

        return "0";
    }
}
