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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequest;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequestApplicationDetails;
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
 * Unit test class for the ApplicationRequest model.
 */
public class ApplicationRequestTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApplicationRequest() throws Throwable {
    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("cos://bucket_name.my_cos/my_spark_app.py")
      .xClass("com.company.path.ClassName")
      .arguments(new java.util.ArrayList<String>(java.util.Arrays.asList("[arg1, arg2, arg3]")))
      .conf(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .env(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(applicationRequestApplicationDetailsModel.application(), "cos://bucket_name.my_cos/my_spark_app.py");
    assertEquals(applicationRequestApplicationDetailsModel.xClass(), "com.company.path.ClassName");
    assertEquals(applicationRequestApplicationDetailsModel.arguments(), new java.util.ArrayList<String>(java.util.Arrays.asList("[arg1, arg2, arg3]")));
    assertEquals(applicationRequestApplicationDetailsModel.conf(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(applicationRequestApplicationDetailsModel.env(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    ApplicationRequest applicationRequestModel = new ApplicationRequest.Builder()
      .applicationDetails(applicationRequestApplicationDetailsModel)
      .build();
    assertEquals(applicationRequestModel.applicationDetails(), applicationRequestApplicationDetailsModel);

    String json = TestUtilities.serialize(applicationRequestModel);

    ApplicationRequest applicationRequestModelNew = TestUtilities.deserialize(json, ApplicationRequest.class);
    assertTrue(applicationRequestModelNew instanceof ApplicationRequest);
    assertEquals(applicationRequestModelNew.applicationDetails().toString(), applicationRequestApplicationDetailsModel.toString());
  }
}