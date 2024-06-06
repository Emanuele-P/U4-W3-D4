package ep2024.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("----------The event with id: " + id + " has not been found.");
    }
}
