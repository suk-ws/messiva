package cc.sukazyo.messiva.io;

/**
 * IO interface for active messages.
 *
 * <p color=orange>Currently a draft only.</p>
 *
 * <p>
 *     This IO Binder should manage some of the active messages, which means the message may be
 *     changed during program runs.
 * </p>
 *
 * <p>
 *     In this IO Binder, it should create a ActiveMessage container and return it to the
 *     caller, and a display area (or other type of things that can show characters) will be
 *     reserved for the container to show messages. The caller then be able to modify the
 *     message content as needed, every change will be reflected to the reserved display area.
 *     After the container is not needed, the caller should call to release the container to
 *     free the reserved display area.
 * </p>
 */
public interface ActiveIOBinder {

}
