package com.cyrillrx.tracker.event;

import java.util.Map;

/**
 * @author Cyril Leroux
 *         Created on 24/11/2015.
 */
public class ActionEvent extends TrackEvent {

    protected String action;

    protected int     intValue;
    protected long    longValue;
    protected float   floatValue;
    protected boolean boolValue;

    ActionEvent() { }

    public String getAction() { return action; }

    public int getIntValue() { return intValue; }

    public long getLongValue() { return longValue; }

    public float getFloatValue() { return floatValue; }

    public boolean getBoolValue() { return boolValue; }

    public static class Builder {

        private final ActionEvent event;

        public Builder() { event = new ActionEvent(); }

        public ActionEvent build() {
            if (event.category == null || event.category.isEmpty() ||
                    event.action == null || event.action.isEmpty()) {
                throw new IllegalStateException("Category and action are mandatory");
            }

            return event;
        }

        public Builder setCategory(String category) {
            event.category = category;
            return this;
        }

        public Builder setId(String id) {
            event.id = id;
            return this;
        }

        public Builder setType(String type) {
            event.type = type;
            return this;
        }

        public Builder setName(String name) {
            event.name = name;
            return this;
        }

        public Builder setAction(String action) {
            event.action = action;
            return this;
        }

        public Builder setValue(int value) {
            event.intValue = value;
            return this;
        }

        public Builder setValue(long value) {
            event.longValue = value;
            return this;
        }

        public Builder setValue(float value) {
            event.floatValue = value;
            return this;
        }

        public Builder setValue(boolean value) {
            event.boolValue = value;
            return this;
        }

        public Builder putCustomAttribute(String key, String value) {
            event.customAttributes.put(key, value);
            return this;
        }

        public Builder putCustomAttributes(Map<String, String> values) {
            event.customAttributes.putAll(values);
            return this;
        }
    }
}