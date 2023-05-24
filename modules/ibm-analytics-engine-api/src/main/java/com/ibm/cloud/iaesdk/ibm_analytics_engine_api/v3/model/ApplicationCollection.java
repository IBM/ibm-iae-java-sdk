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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A paginated collection of applications.
 */
public class ApplicationCollection extends GenericModel {

  protected List<Application> applications;
  protected PageLink first;
  protected PageLink next;
  protected PageLink previous;
  protected Long limit;

  protected ApplicationCollection() { }

  /**
   * Gets the applications.
   *
   * List of applications.
   *
   * @return the applications
   */
  public List<Application> getApplications() {
    return applications;
  }

  /**
   * Gets the first.
   *
   * A reference to a page in a paginated collection.
   *
   * @return the first
   */
  public PageLink getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * A reference to a page in a paginated collection.
   *
   * @return the next
   */
  public PageLink getNext() {
    return next;
  }

  /**
   * Gets the previous.
   *
   * A reference to a page in a paginated collection.
   *
   * @return the previous
   */
  public PageLink getPrevious() {
    return previous;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of results in this page of the collection.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }
}

