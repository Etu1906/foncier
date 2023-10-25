package serialisers;

import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CustomDateSerializer implements JsonbSerializer<Date> {

  private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public void serialize(
    Date value,
    JsonGenerator generator,
    SerializationContext ctx
  ) {
    String formattedDate = formatter.format(value);
    generator.write(formattedDate);
  }
}
