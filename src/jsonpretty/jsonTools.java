package jsonpretty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Genaro Coronel
 * @contribucion json parser
 */
public class jsonTools {

    public static DefaultMutableTreeNode buildTree(String name, JsonNode node) {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(name);

        Iterator<Entry<String, JsonNode>> it = node.fields();
        while (it.hasNext()) {
            Entry<String, JsonNode> entry = it.next();
            treeNode.add(buildTree(entry.getKey(), entry.getValue()));
        }

        if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                JsonNode child = node.get(i);
                if (child.isValueNode()) {
                    treeNode.add(new DefaultMutableTreeNode(child.asText()));
                } else {
                    treeNode.add(buildTree(String.format("[%d]", i), child));
                }
            }
        } else if (node.isValueNode()) {
            treeNode.add(new DefaultMutableTreeNode(node.asText()));
        }

        return treeNode;
    }

    public static DefaultMutableTreeNode getModel(String jsonString) throws FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        //JsonNode rootJsonNode = mapper.readTree(new FileInputStream(jsonString));
        JsonNode rootJsonNode = mapper.readTree(jsonString);

        // Construct tree model
        DefaultMutableTreeNode rootNode = buildTree("[ ]", rootJsonNode);
        return rootNode;
    }

    //public static JsonElement toTree(String jsonString) {
    //   JsonParser parser = new JsonParser();
    //  JsonElement jsonTree = parser.parse(jsonString);
    // return jsonTree;
    // }
    public static String toPrettyFormat(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

}
