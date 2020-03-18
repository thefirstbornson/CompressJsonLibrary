package com.thefirstbornson.compressjson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompressionCriteria {
    private List<String> expansionsList;
    private StringBuilder path;
    private String delimiter;
    private String identifier;

    CompressionCriteria(List<String> expansionsList, StringBuilder path, String delimiter, String identifier) {
        this.expansionsList = expansionsList;
        this.path = path;
        this.delimiter = delimiter;
        this.identifier = identifier;
    }

    public static CompressionCriteriaBuilder builder() {
        return new CompressionCriteriaBuilder();
    }

    public StringBuilder appendPath(String pathToAppend){
        return this.path.append(pathToAppend);
    }

    public List<String> getExpansionsList() {
        return this.expansionsList;
    }

    public StringBuilder getPath() {
        return this.path;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public static class CompressionCriteriaBuilder {
        private ArrayList<String> expansionsList;
        private StringBuilder path = new StringBuilder();
        private String delimiter;
        private String identifier;

        CompressionCriteriaBuilder() {
        }

        public CompressionCriteria.CompressionCriteriaBuilder expansionsList(String expansionsList) {
            if (this.expansionsList == null) this.expansionsList = new ArrayList<String>();
            this.expansionsList.add(expansionsList);
            return this;
        }

        public CompressionCriteria.CompressionCriteriaBuilder expansionsList(Collection<? extends String> expansionsList) {
            if (this.expansionsList == null) this.expansionsList = new ArrayList<String>();
            this.expansionsList.addAll(expansionsList);
            return this;
        }

        public CompressionCriteria.CompressionCriteriaBuilder clearExpansionsList() {
            if (this.expansionsList != null)
                this.expansionsList.clear();
            return this;
        }



        public CompressionCriteria.CompressionCriteriaBuilder path(StringBuilder path) {
            this.path = path;
            return this;
        }

        public CompressionCriteria.CompressionCriteriaBuilder delimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public CompressionCriteria.CompressionCriteriaBuilder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public CompressionCriteria build() {
            List<String> expansionsList;
            switch (this.expansionsList == null ? 0 : this.expansionsList.size()) {
                case 0:
                    expansionsList = java.util.Collections.emptyList();
                    break;
                case 1:
                    expansionsList = java.util.Collections.singletonList(this.expansionsList.get(0));
                    break;
                default:
                    expansionsList = java.util.Collections.unmodifiableList(new ArrayList<String>(this.expansionsList));
            }
            return new CompressionCriteria(expansionsList, path, delimiter, identifier);
        }

        public String toString() {
            return "CompressionCriteria.CompressionCriteriaBuilder(expansionsList=" + this.expansionsList + ", path=" + this.path + ", delimiter=" + this.delimiter + ", identifier=" + this.identifier + ")";
        }
    }
}
