package gn.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointTest {
    private String json = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1553939267147}";
    private final String autoId = "o567gfd";
    private String autoID = autoId;

    @Test
    public void encodeDTO() throws Exception {
        Point point = new Point();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId(autoId);
        point.setTime(System.currentTimeMillis());
        String pointJson = point.toJson();
        assertTrue(pointJson.contains("\"lat\":56"));
        assertTrue(pointJson.contains("\"time\":"));
        System.out.println(pointJson);
    }

    @Test
    public void decodeDTO() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Point dto = mapper.readValue(json, Point.class);
        assertEquals(autoID, dto.getAutoId());
        assertEquals(1553939267147L, dto.getTime());

    }
}
