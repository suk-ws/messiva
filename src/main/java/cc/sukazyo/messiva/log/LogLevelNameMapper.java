package cc.sukazyo.messiva.log;

import java.util.HashMap;
import java.util.Map;

/**
 * A mapper that can map a {@link ILogLevel} to a friendly name.
 *
 * <p>
 *     Names need to be registered using {@link #mapName(ILogLevel, String)}.
 *     After that, the log levels name can be retrieved using {@link #getName(ILogLevel)}.
 * </p>
 *
 * <h2>Log level to names</h2>
 *
 * <p>
 *     When trying to retrieve a name for a {@link ILogLevel}, the mapper will try to retrieve
 *     names in the following order:
 * </p>
 * <ol>
 *     <li>Check if the specific {@link ILogLevel} is registered with a name, and get the name.
 *     This is checked by comparing the exact object-level match about a {@link ILogLevel}
 *     instance, so that different {@link ILogLevel} with the same {@link ILogLevel#id}, will
 *     be treated differently.</li>
 *     <li>If the above method fails, then mapper will check if any of one {@link ILogLevel}
 *     with the same {@link ILogLevel#id} is registered with a name. If there is a matched
 *     one, that name will be returned. In this method, two or more {@link ILogLevel} with the
 *     same {@link ILogLevel#id} can share one name if only one of them has registered.</li>
 *     <li>If the above fails, it will check whether the {@link ILogLevel} is defined in an
 *     {@link Enum}. If so, the enum's {@link Enum#name()} will be used as the name.</li>
 *     <li>If all of the above fails, the {@link ILogLevel#id()} string will be used as the name.</li>
 * </ol>
 *
 * <h2>Global Mapper</h2>
 *
 * <p>
 *     An {@link #GLOBAL} mapper is provided with default name mappings about the
 *     {@link LogLevels standard log levels}.
 * </p>
 *
 * <p>
 *     We recommend any library author add their custom log levels to the global mapper, as a
 *     default method for users who do not provide their own mappers.
 * </p>
 */
public class LogLevelNameMapper {
	
	public static final LogLevelNameMapper GLOBAL = new LogLevelNameMapper();
	
	private final Map<ILogLevel, String> mapper = new HashMap<>();
	private final Map<String, String> idMapper = new HashMap<>();
	
	public void mapName (ILogLevel level, String name) {
		mapper.put(level, name);
		idMapper.put(level.id(), name);
	}
	
	public String getName (ILogLevel level) {
		if (mapper.containsKey(level)) {
			return mapper.get(level);
		} else if (idMapper.containsKey(level.id())) {
			return idMapper.get(level.id());
		} else if (level instanceof Enum<?>) {
			return ((Enum<?>) level).name();
		} else {
			return level.id();
		}
	}
	
}
