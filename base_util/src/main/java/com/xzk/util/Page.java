package com.xzk.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by XiaoZK on 2016/11/8.
 */
public class Page {
    private int begin;
    private int end;
    private int length;
    private int count;
    private int current;
    private int total;
    private List records;

    public Page() {
        this.records = Lists.newArrayList();
    }

    public Page(int begin, int length) {
        this.records = Lists.newArrayList();
        this.begin = begin;
        this.length = length;
        this.end = this.begin + this.length;
        this.current = (int)Math.floor((double)this.begin * 1.0D / (double)this.length) + 1;
    }

    public Page(int begin, int length, int count) {
        this(begin, length);
        this.count = count;
    }

    public int getBegin() {
        return this.begin;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setBegin(int begin) {
        this.begin = begin;
        if(this.length != 0) {
            this.current = (int)Math.floor((double)this.begin * 1.0D / (double)this.length) + 1;
        }

    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
        if(this.begin != 0) {
            this.current = (int)Math.floor((double)this.begin * 1.0D / (double)this.length) + 1;
        }

    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
        this.total = (int)Math.floor((double)this.count * 1.0D / (double)this.length);
        if(this.count % this.length != 0) {
            ++this.total;
        }

    }

    public int getCurrent() {
        return this.current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return this.total == 0?1:this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRecords() {
        return this.records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
}
