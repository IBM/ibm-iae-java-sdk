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
 * Unit test class for the ApplicationRequestApplicationDetails model.
 */
public class ApplicationRequestApplicationDetailsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApplicationRequestApplicationDetails() throws Throwable {
    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("testString")
      .xClass("testString")
      .applicationArguments(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .conf(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .env(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(applicationRequestApplicationDetailsModel.application(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.xClass(), "testString");
    assertEquals(applicationRequestApplicationDetailsModel.applicationArguments(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(applicationRequestApplicationDetailsModel.conf(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(applicationRequestApplicationDetailsModel.env(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    String json = TestUtilities.serialize(applicationRequestApplicationDetailsModel);

    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModelNew = TestUtilities.deserialize(json, ApplicationRequestApplicationDetails.class);
    assertTrue(applicationRequestApplicationDetailsModelNew instanceof ApplicationRequestApplicationDetails);
    assertEquals(applicationRequestApplicationDetailsModelNew.application(), "testString");
    assertEquals(applicationRequestApplicationDetailsModelNew.xClass(), "testString");
  }
}