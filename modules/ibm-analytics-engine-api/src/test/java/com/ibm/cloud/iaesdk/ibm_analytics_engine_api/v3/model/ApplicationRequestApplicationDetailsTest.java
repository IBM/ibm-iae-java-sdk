/*
 * (C) Copyright IBM Corp. 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model;

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequestApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Runtime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ApplicationRequestApplicationDetails model.
 */
public class ApplicationRequestApplicationDetailsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApplicationRequestApplicationDetails() throws Throwable {
    Runtime runtimeModel = new Runtime.Builder()
      .sparkVersion("3.1")
      .build();
    assertEquals(runtimeModel.sparkVersion(), "3.1");

    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("cos://bucket_name.my_cos/my_spark_app.py")
      .runtime(runtimeModel)
      .jars("cos://cloud-object-storage/jars/tests.jar")
      .packages("testString")
      .repositories("testString")
      .files("testString")
      .archives("testString")
      .name("spark-app")
      .xClass("com.company.path.ClassName")
      .arguments(java.util.Arrays.asList("[arg1, arg2, arg3]"))
      .conf(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .env(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(applicationRequestApplicationDetailsModel.application(), "cos://bucket_name.my_cos/my_spark_app.py");
    assertEquals(applicationRequestApplicationDetailsModel.runtime(), runtimeModel);
    assertEquals(applicationRequestApplicationDetailsModel.jars(), "cos://cloud-object-storage/jars/tests.jar");
    assertEquals(applicationRequestApplicationDetailsModel.packages(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.repositories(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.files(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.archives(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.name(), "spark-app");
    assertEquals(applicationRequestApplicationDetailsModel.xClass(), "com.company.path.ClassName");
    assertEquals(applicationRequestApplicationDetailsModel.arguments(), java.util.Arrays.asList("[arg1, arg2, arg3]"));
    assertEquals(applicationRequestApplicationDetailsModel.conf(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(applicationRequestApplicationDetailsModel.env(), java.util.Collections.singletonMap("anyKey", "anyValue"));

    String json = TestUtilities.serialize(applicationRequestApplicationDetailsModel);

    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModelNew = TestUtilities.deserialize(json, ApplicationRequestApplicationDetails.class);
    assertTrue(applicationRequestApplicationDetailsModelNew instanceof ApplicationRequestApplicationDetails);
    assertEquals(applicationRequestApplicationDetailsModelNew.application(), "cos://bucket_name.my_cos/my_spark_app.py");
    assertEquals(applicationRequestApplicationDetailsModelNew.runtime().toString(), runtimeModel.toString());
    assertEquals(applicationRequestApplicationDetailsModelNew.jars(), "cos://cloud-object-storage/jars/tests.jar");
    assertEquals(applicationRequestApplicationDetailsModelNew.packages(), "testString");
    assertEquals(applicationRequestApplicationDetailsModelNew.repositories(), "testString");
    assertEquals(applicationRequestApplicationDetailsModelNew.files(), "testString");
    assertEquals(applicationRequestApplicationDetailsModelNew.archives(), "testString");
    assertEquals(applicationRequestApplicationDetailsModelNew.name(), "spark-app");
    assertEquals(applicationRequestApplicationDetailsModelNew.xClass(), "com.company.path.ClassName");
    assertEquals(applicationRequestApplicationDetailsModelNew.conf().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(applicationRequestApplicationDetailsModelNew.env().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
  }
}