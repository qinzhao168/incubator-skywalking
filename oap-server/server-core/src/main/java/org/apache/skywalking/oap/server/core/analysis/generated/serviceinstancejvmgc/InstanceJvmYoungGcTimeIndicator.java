/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.core.analysis.generated.serviceinstancejvmgc;

import java.util.*;
import lombok.*;
import org.apache.skywalking.oap.server.core.Const;
import org.apache.skywalking.oap.server.core.alarm.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.annotation.IndicatorType;
import org.apache.skywalking.oap.server.core.remote.annotation.StreamData;
import org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteData;
import org.apache.skywalking.oap.server.core.source.Scope;
import org.apache.skywalking.oap.server.core.storage.StorageBuilder;
import org.apache.skywalking.oap.server.core.storage.annotation.*;

/**
 * This class is auto generated. Please don't change this class manually.
 *
 * @author Observability Analysis Language code generator
 */
@IndicatorType
@StreamData
@StorageEntity(name = "instance_jvm_young_gc_time", builder = InstanceJvmYoungGcTimeIndicator.Builder.class)
public class InstanceJvmYoungGcTimeIndicator extends LongAvgIndicator implements AlarmSupported {

    @Setter @Getter @Column(columnName = "entity_id") @IDColumn private String entityId;
    @Setter @Getter @Column(columnName = "service_instance_id")  private int serviceInstanceId;

    @Override public String id() {
        String splitJointId = String.valueOf(getTimeBucket());
        splitJointId += Const.ID_SPLIT + entityId;
        return splitJointId;
    }

    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + entityId.hashCode();
        result = 31 * result + (int)getTimeBucket();
        return result;
    }


    @Override public int remoteHashCode() {
        int result = 17;
        result = 31 * result + entityId.hashCode();
        return result;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        InstanceJvmYoungGcTimeIndicator indicator = (InstanceJvmYoungGcTimeIndicator)obj;
        if (entityId != indicator.entityId)
            return false;

        if (getTimeBucket() != indicator.getTimeBucket())
            return false;

        return true;
    }

    @Override public RemoteData.Builder serialize() {
        RemoteData.Builder remoteBuilder = RemoteData.newBuilder();
        remoteBuilder.setDataStrings(0, getEntityId());

        remoteBuilder.setDataLongs(0, getSummation());
        remoteBuilder.setDataLongs(1, getValue());
        remoteBuilder.setDataLongs(2, getTimeBucket());


        remoteBuilder.setDataIntegers(0, getServiceInstanceId());
        remoteBuilder.setDataIntegers(1, getCount());

        return remoteBuilder;
    }

    @Override public void deserialize(RemoteData remoteData) {
        setEntityId(remoteData.getDataStrings(0));

        setSummation(remoteData.getDataLongs(0));
        setValue(remoteData.getDataLongs(1));
        setTimeBucket(remoteData.getDataLongs(2));


        setServiceInstanceId(remoteData.getDataIntegers(0));
        setCount(remoteData.getDataIntegers(1));


    }

    @Override public AlarmMeta getAlarmMeta() {
        return new AlarmMeta("instance_jvm_young_gc_time", Scope.ServiceInstanceJVMGC, entityId);
    }

    @Override
    public Indicator toHour() {
        InstanceJvmYoungGcTimeIndicator indicator = new InstanceJvmYoungGcTimeIndicator();
        indicator.setTimeBucket(toTimeBucketInHour());
        indicator.setEntityId(this.getEntityId());
        indicator.setServiceInstanceId(this.getServiceInstanceId());
        indicator.setSummation(this.getSummation());
        indicator.setCount(this.getCount());
        indicator.setValue(this.getValue());
        return indicator;
    }

    @Override
    public Indicator toDay() {
        InstanceJvmYoungGcTimeIndicator indicator = new InstanceJvmYoungGcTimeIndicator();
        indicator.setTimeBucket(toTimeBucketInDay());
        indicator.setEntityId(this.getEntityId());
        indicator.setServiceInstanceId(this.getServiceInstanceId());
        indicator.setSummation(this.getSummation());
        indicator.setCount(this.getCount());
        indicator.setValue(this.getValue());
        return indicator;
    }

    @Override
    public Indicator toMonth() {
        InstanceJvmYoungGcTimeIndicator indicator = new InstanceJvmYoungGcTimeIndicator();
        indicator.setTimeBucket(toTimeBucketInMonth());
        indicator.setEntityId(this.getEntityId());
        indicator.setServiceInstanceId(this.getServiceInstanceId());
        indicator.setSummation(this.getSummation());
        indicator.setCount(this.getCount());
        indicator.setValue(this.getValue());
        return indicator;
    }

    public static class Builder implements StorageBuilder<InstanceJvmYoungGcTimeIndicator> {

        @Override public Map<String, Object> data2Map(InstanceJvmYoungGcTimeIndicator storageData) {
            Map<String, Object> map = new HashMap<>();
            map.put("entity_id", storageData.getEntityId());
            map.put("service_instance_id", storageData.getServiceInstanceId());
            map.put("summation", storageData.getSummation());
            map.put("count", storageData.getCount());
            map.put("value", storageData.getValue());
            map.put("time_bucket", storageData.getTimeBucket());
            return map;
        }

        @Override public InstanceJvmYoungGcTimeIndicator map2Data(Map<String, Object> dbMap) {
            InstanceJvmYoungGcTimeIndicator indicator = new InstanceJvmYoungGcTimeIndicator();
            indicator.setEntityId((String)dbMap.get("entity_id"));
            indicator.setServiceInstanceId(((Number)dbMap.get("service_instance_id")).intValue());
            indicator.setSummation(((Number)dbMap.get("summation")).longValue());
            indicator.setCount(((Number)dbMap.get("count")).intValue());
            indicator.setValue(((Number)dbMap.get("value")).longValue());
            indicator.setTimeBucket(((Number)dbMap.get("time_bucket")).longValue());
            return indicator;
        }
    }
}
