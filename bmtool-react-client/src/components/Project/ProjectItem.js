import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteProject } from "../../actions/projectActions";

class ProjectItem extends Component {
  onClickDelete = id => {
    this.props.deleteProject(id);
  };
  render() {
    const { project } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">{project.blogIdentifier}</span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{project.title}</h3>
              <p>{project.metaDescription}</p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <a href="#">
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1"> View Blog Post</i>
                  </li>
                </a>
                <Link to={`/updateBlog/${project.blogIdentifier}`}>
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1"> Update Blog</i>
                  </li>
                </Link>
                <li
                  className="list-group-item delete"
                  onClick={this.onClickDelete.bind(
                    this,
                    project.blogIdentifier
                  )}
                >
                  <i className="fa fa-minus-circle pr-1"> Delete Blog</i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
ProjectItem.propTypes = {
  deleteProject: PropTypes.func.isRequired
};
export default connect(
  null,
  { deleteProject }
)(ProjectItem);
