import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SocketTextStreamFunction;

/**
 * @author quxiuchengls
 * @date 2019-08-31 11:35:00
 */
public class SocketMain {
	public static void main(String[] args) throws Exception {
		StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
		DataStreamSource<String> localhost = executionEnvironment.addSource(new SocketTextStreamFunction("localhost", 8888, "\n", 0));
		localhost.print();
		executionEnvironment.execute("aa");
	}
}
