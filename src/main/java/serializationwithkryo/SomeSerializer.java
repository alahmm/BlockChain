package serializationwithkryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/*public class SomeSerializer extends Serializer<SomeClass> {
    @Override
    public void write (Kryo kryo, Output output, SomeClass someClass) {
        output.writeString(someClass.getValue());
    }
    @Override
    public SomeClass read (Kryo kryo, Input input, Class<? extends SomeClass> type) {
        return new SomeClass(input.readString());
    }
}*/
