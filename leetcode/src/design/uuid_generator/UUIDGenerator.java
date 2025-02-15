package design.uuid_generator;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.UUID;

public class UUIDGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        System.out.println(generateV7Uuid());
    }


    private static String generateV7Uuid() {
        long timestamp = Instant.now().toEpochMilli();

        // Step 1: Extract timestamp (48 bits) and shift left to make room for randomness
        long timeHigh = (timestamp & 0XFFFFFFFFFFFFL) << 16;

        // Step 2: Add 12-bit randomness using SecureRandom
        long random12Bits = RANDOM.nextInt(1 << 12) & 0x0FFF;
        timeHigh |= random12Bits;

        // // Step 3: Set UUID Version (7) in bits 60-63
        timeHigh |= (0x7L << 60);

        // Step 4: Generate 64-bit randomness and set variant
        long leastSigBits = RANDOM.nextLong();

        // Step 5: Clear first two bits for variant field
        leastSigBits &= 0x3FFFFFFFFFFFFFFFL;

        // Step 6: Set variant (`10xx`) per RFC 4122
        leastSigBits |= 0x8000000000000000L;

        // Step 7: Create UUID
        UUID uuid = new UUID(timeHigh, leastSigBits);

        return uuid.toString();
    }


    private static String formatUUID(long mostSigBits, long leastSigBits) {
        return String.format("%08x-%04x-%04x-%04x-%012x",
                (mostSigBits >>> 32), (mostSigBits >>> 16) & 0xFFFF, (mostSigBits & 0xFFFF),
                (leastSigBits >>> 48), (leastSigBits & 0xFFFFFFFFFFFFL));
    }
}