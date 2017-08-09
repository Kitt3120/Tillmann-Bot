package de.vanillekeks.tillmannbot.audio;

public class TrackNotInQueueException extends Exception {

    public TrackNotInQueueException() {
        super();
    }

    public TrackNotInQueueException(String message) {
        super(message);
    }

    public TrackNotInQueueException(Throwable cause) {
        super(cause);
    }

    public TrackNotInQueueException(String message, Throwable cause) {
        super(message, cause);
    }

}
