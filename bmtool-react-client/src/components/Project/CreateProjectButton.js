import React from "react";
import { Link } from "react-router-dom";
function CreateProjectButton() {
  return (
    <React.Fragment>
      <Link to="/addBlog" class="btn btn-lg btn-info">
        Create New Blog
      </Link>
    </React.Fragment>
  );
}
export default CreateProjectButton;
