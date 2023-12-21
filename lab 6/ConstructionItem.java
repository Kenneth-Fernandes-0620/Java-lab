public interface ConstructionItem extends Comparable<ConstructionItem> {
    void use();
    @Override
    default int compareTo(ConstructionItem other) {
        return toString().compareTo(other.toString());
    }
}