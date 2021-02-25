package csw.study.main.models;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ListCard {
    private final JsonObject result = new JsonObject();
    private final JsonObject outputs = new JsonObject();
    private final JsonArray outputsArr = new JsonArray();
    private final JsonObject listCard = new JsonObject();
    private final JsonObject listCardInner = new JsonObject();

    private final JsonArray buttons = new JsonArray();
    private final JsonArray items = new JsonArray();


    public ListCard() {
        listCard.add("buttons", buttons);
        listCard.add("items", items);

        listCardInner.add("listCard", listCard);
        outputsArr.add(listCardInner);
        outputs.add("outputs", outputsArr);
        result.add("template", outputs);
        result.addProperty("version", "2.0");
    }

    public void setTitle(String title) {
        JsonObject header = new JsonObject();
        header.addProperty("title", title);

        result.getAsJsonObject("template").getAsJsonArray("outputs").get(0).getAsJsonObject().getAsJsonObject("listCard").add("header", header);
    }

    public void addShareButton(String label) {
        JsonObject shareBtn = new JsonObject();
        shareBtn.addProperty("action", "share");
        shareBtn.addProperty("label", label);
        this.buttons.add(shareBtn);
    }

    public void addLinkButton(String label, String link) {
        JsonObject linkBtn = new JsonObject();
        linkBtn.addProperty("action", "webLink");
        linkBtn.addProperty("label", label);
        linkBtn.addProperty("webLinkUrl", link);
        this.buttons.add(linkBtn);
    }

    public String toString() {
        return result.toString();
    }
}