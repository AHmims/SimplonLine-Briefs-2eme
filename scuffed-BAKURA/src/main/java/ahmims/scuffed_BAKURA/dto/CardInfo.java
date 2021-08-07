package ahmims.scuffed_BAKURA.dto;

public class CardInfo {
    public CardData[] data;

    public CardInfo(CardData[] data) {
        this.data = data;
    }

    public CardData[] getData() {
        return data;
    }

    public void setData(CardData[] data) {
        this.data = data;
    }

    public class CardData {
        private int id;
        private String name;
        private String type;
        private String desc;
        private int atk;
        private int def;
        private int level;
        private String race;
        private String attribute;
        private String archetype;
        private int scale;
        private int linkval;
        private CardImage[] card_images;

        public CardData(int id, String name, String type, String desc, int atk, int def, int level, String race, String attribute, String archetype, int scale, int linkval, CardImage[] card_images) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.desc = desc;
            this.atk = atk;
            this.def = def;
            this.level = level;
            this.race = race;
            this.attribute = attribute;
            this.archetype = archetype;
            this.scale = scale;
            this.linkval = linkval;
            this.card_images = card_images;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getAtk() {
            return atk;
        }

        public void setAtk(int atk) {
            this.atk = atk;
        }

        public int getDef() {
            return def;
        }

        public void setDef(int def) {
            this.def = def;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }

        public String getArchetype() {
            return archetype;
        }

        public void setArchetype(String archetype) {
            this.archetype = archetype;
        }

        public int getScale() {
            return scale;
        }

        public void setScale(int scale) {
            this.scale = scale;
        }

        public int getLinkval() {
            return linkval;
        }

        public void setLinkval(int linkval) {
            this.linkval = linkval;
        }

        public CardImage[] getCard_images() {
            return card_images;
        }

        public void setCard_images(CardImage[] card_images) {
            this.card_images = card_images;
        }
    }

    public class CardImage {
        private String id;
        private String image_url;
        private String image_url_small;

        public CardImage(String id, String image_url, String image_url_small) {
            this.id = id;
            this.image_url = image_url;
            this.image_url_small = image_url_small;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_url_small() {
            return image_url_small;
        }

        public void setImage_url_small(String image_url_small) {
            this.image_url_small = image_url_small;
        }
    }
}
