import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createProject } from "../../actions/projectActions";
import classnames from "classnames";

class AddProject extends Component {
  constructor() {
    super();
    this.state = {
      title: "",
      body: "",
      blogIdentifier: "",
      metaDescription: "",
      date: "",
      errors:{}
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  componentWillReceiveProps(nextProps){
    if(nextProps.errors){
      this.setState({ errors: nextProps.errors});
    }
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const newBlog = {
      title: this.state.title,
      body: this.state.body,
      blogIdentifier: this.state.blogIdentifier,
      metaDescription: this.state.metaDescription,
      date: this.state.date
    };
    this.props.createProject(newBlog, this.props.history);
  }
  render() {
    let styles = {
      margin: "10px"
    };
    const {errors} =this.state;
    return (
      <div>
      <div className="project" style={styles}>
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create / Edit Blog</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className={classnames("form-control form-control-lg", {
                    "is-invalid":errors.title
                    })}
                    placeholder="Blog Title"
                    name="title"
                    value={this.state.title}
                    onChange={this.onChange}
                  />
                  {errors.title && (
                    <div className="invalid-feedback">
                      {errors.title}
                      </div>
                  )}
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className={classnames("form-control form-control-lg", {
                      "is-invalid":errors.blogIdentifier
                      })}
                    placeholder="Unique Blog ID"
                    name="blogIdentifier"
                    value={this.state.blogIdentifier}
                    onChange={this.onChange}
                  />
                  {errors.blogIdentifier && (
                    <div className="invalid-feedback">
                      {errors.blogIdentifier}
                      </div>
                  )}
                </div>
                <div className="form-group">
                  <textarea
                    rows="10"
                    className={classnames("form-control form-control-lg", {
                      "is-invalid":errors.body
                      })}
                    placeholder="Body"
                    name="body"
                    value={this.state.body}
                    onChange={this.onChange}
                  />
                  {errors.body && (
                    <div className="invalid-feedback">
                      {errors.body}
                      </div>
                  )}
                </div>
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Meta Description"
                    name="metaDescription"
                    value={this.state.metaDescription}
                    onChange={this.onChange}
                  />
                </div>
                <h6>Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="date"
                    value={this.state.date}
                    onChange={this.onChange}
                  />
                </div>
                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
              </form>
            </div>
          </div>
        </div>
      </div>
      </div>
    );
  }
}
AddProject.propTypes = {
  createProject: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps =state =>({
  errors:state.errors
})

export default connect(
  mapStateToProps,
  { createProject }
)(AddProject);
