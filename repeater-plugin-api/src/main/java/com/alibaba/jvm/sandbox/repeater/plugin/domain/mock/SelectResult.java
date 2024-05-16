package com.alibaba.jvm.sandbox.repeater.plugin.domain.mock;

import com.alibaba.jvm.sandbox.repeater.plugin.domain.Invocation;

import java.beans.ConstructorProperties;


/**
 * <p>
 *
 * @author zhaoyb1990
 */
public class SelectResult {

    private boolean match;

    private Invocation invocation;

    private Long cost;

    private boolean diff;

    @ConstructorProperties({"match", "invocation", "cost", "diff"})
    SelectResult(boolean match, Invocation invocation, Long cost, boolean diff) {
        this.match = match;
        this.invocation = invocation;
        this.cost = cost;
        this.diff = diff;
    }

    public boolean isDiff() {
        return diff;
    }

    public static SelectResult.SelectResultBuilder builder() {
        return new SelectResult.SelectResultBuilder();
    }

    public boolean isMatch() {
        return this.match;
    }

    public Invocation getInvocation() {
        return this.invocation;
    }

    public Long getCost() {
        return this.cost;
    }

    public static class SelectResultBuilder {
        private boolean match;
        private Invocation invocation;
        private Long cost;

        private boolean diff = true;

        SelectResultBuilder() {
        }

        public SelectResult.SelectResultBuilder diff(boolean diff) {
            this.diff = diff;
            return this;
        }

        public SelectResult.SelectResultBuilder match(boolean match) {
            this.match = match;
            return this;
        }

        public SelectResult.SelectResultBuilder invocation(Invocation invocation) {
            this.invocation = invocation;
            return this;
        }

        public SelectResult.SelectResultBuilder cost(Long cost) {
            this.cost = cost;
            return this;
        }

        public SelectResult build() {
            return new SelectResult(this.match, this.invocation, this.cost, this.diff);
        }

        @Override
        public String toString() {
            return "SelectResult.SelectResultBuilder(match=" + this.match + ", invocation=" + this.invocation + ", cost=" + this.cost + ")";
        }
    }
}
