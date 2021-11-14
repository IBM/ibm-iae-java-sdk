/*
 * (C) Copyright IBM Corp. 2021.
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateApplicationOptions model.
 */
public class CreateApplicationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateApplicationOptions() throws Throwable {
    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("cos://bucket_name.my_cos/my_spark_app.py")
      .jars("cos://cloud-object-storage/jars/tests.jar")
      .packages("testString")
      .repositories("testString")
      .files("testString")
      .archives("testString")
      .name("spark-app")
      .xClass("com.company.path.ClassName")
      .arguments(new java.util.ArrayList<String>(java.util.Arrays.asList("[arg1, arg2, arg3]")))
      .conf(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .env(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(applicationRequestApplicationDetailsModel.application(), "cos://bucket_name.my_cos/my_spark_app.py");
    assertEquals(applicationRequestApplicationDetailsModel.jars(), "cos://cloud-object-storage/jars/tests.jar");
    assertEquals(applicationRequestApplicationDetailsModel.packages(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.repositories(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.files(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.archives(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.name(), "spark-app");
    assertEquals(applicationRequestApplicationDetailsModel.xClass(), "com.company.path.ClassName");
    assertEquals(applicationRequestApplicationDetailsModel.arguments(), new java.util.ArrayList<String>(java.util.Arrays.asList("[arg1, arg2, arg3]")));
    assertEquals(applicationRequestApplicationDetailsModel.conf(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(applicationRequestApplicationDetailsModel.env(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    CreateApplicationOptions createApplicationOptionsModel = new CreateApplicationOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .applicationDetails(applicationRequestApplicationDetailsModel)
      .build();
    assertEquals(createApplicationOptionsModel.instanceId(), "e64c907a-e82f-46fd-addc-ccfafbd28b09");
    assertEquals(createApplicationOptionsModel.applicationDetails(), applicationRequestApplicationDetailsModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateApplicationOptionsError() throws Throwable {
    new CreateApplicationOptions.Builder().build();
  }

}