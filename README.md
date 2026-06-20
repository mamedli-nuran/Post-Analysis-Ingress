# Meta API Post Analytics Tool

A backend service that integrates with the **Meta Graph API** to fetch, process, and analyze post data from a page. The project transforms raw social media data into actionable insights through three dedicated API endpoints.

---

## 🚀 Key Features & Endpoints

* **All Posts Data** 
  Retrieves all posts from the page, returning them in the structured Meta API format.
* **Top 3 Posts by Engagement** 
  Analyzes post metrics (likes, comments, shares) to filter and return the **top 3 performing posts**.
* **Best Posting Day** 
  Aggregates historical engagement data to determine the **most optimal day of the week** for audience interaction.
* **Mock posts objects**
  Add stubs for posts that are triggered if the meta api is not available. Posts mock is located in folder util.

## 🛠 API Endpoints Detailed Description

### 1. Get All Posts
* **Endpoint:** `GET /api/v1/posts`
* **Description:** Fetches the complete list of posts from the connected Meta page.
* **Response:** Returns raw data, containing post IDs, creation times, messages, comments and reactions count. 

### 2. Get Top 3 Posts by Engagement
* **Endpoint:** `GET /api/v1/posts/top`
* **Description:** Filters and ranks all fetched posts to find the top 3 top-performing ones.
* **Logic:** Calculates total engagement for each post by aggregating metrics such as **likes, and comments**. Returns an ordered list of the top 3 posts with the highest scores.

### 3. Get Best Posting Day
* **Endpoint:** `GET /api/v1/posts/best-day`
* **Description:** Identifies the most successful day of the week to publish content.
* **Logic:** Grouping posts by the day of creation, it analyzes historical engagement trends to pinpoint which specific day (e.g., Friday) yields the maximum audience interaction.
