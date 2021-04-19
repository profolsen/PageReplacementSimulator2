import java.util.HashMap;

/**
 * Pages are HashMaps with String keys and Integer values.
 * That means additional meta-information can be stored
 * about a page p, such as:y
 * when the page was accessed: p.put("accessTime", t) //where t is an integer representing now
 * how frequently the page is accessed: p.put("frequency", f) //f is the page access frequency.
 * to get, for example, the access time, call p.get("accessTime")
 *
 */
public class Page extends HashMap<String, Integer> {

    /**
     * Creates a new page.
     * @param id the id of the new page.
     */
    public Page(int id) {
        put("id", id);
    }

    /**
     * Returns the id of the page.
     * @return the id of the page.
     */
    public int id()  {  return get("id");  }
}
