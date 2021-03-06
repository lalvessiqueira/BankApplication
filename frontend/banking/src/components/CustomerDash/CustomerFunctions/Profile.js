import React, {Component} from 'react';
import {MDBBtn, MDBInput} from "mdb-react-ui-kit";
import './Profile.css';
import axios from "axios";



class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: window.localStorage.getItem("username"),
            fullName: "",
            customerId: "",
            phone: "",
            secretQuestion: "",
            secretAnswer: "",
            stateID: "",
            ssn: ""
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8081/api/customer/username/" + this.state.username)
            .then((response) => {
                //convert into loop
                this.setState({customerId: response.data.customerId})
                this.setState(response.data.fullName === null ? "" : {fullName: response.data.fullName})
                this.setState(response.data.phone === null ? "" : {phone: response.data.phone})
                this.setState(response.data.ssn=== null ? "" : {ssn: response.data.ssn})
                this.setState(response.data.stateID === null ? "" : {stateID: response.data.stateID})
                this.setState(response.data.secretQuestion === null ? "" : {secretQuestion: response.data.secretQuestion})
                this.setState(response.data.secretAnswer === null ? "" : {secretAnswer: response.data.secretAnswer})
            })
            .catch((error) => {
                console.log(error)
            });
    }

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e => {
        e.preventDefault()
        console.log("this.state:")
        console.log(this.state)
        axios.post('http://localhost:8081/api/customer/' + this.state.customerId, this.state).then(response => {
            console.log(response.data)
            window.localStorage.setItem("username",this.state.username)
        }).catch(error => {
            console.log(error)
            // window.location =  "/infoMismatch"
        })
    }

    render() {
        return (
            <div className='container rounded-3 my-2' id='bg-glass'>
                <form onSubmit={this.submitHandler} className='py-2'>
                    <MDBInput className='mb-4' style={{color: 'black'}}
                        label="Customer ID"
                        placeholder={this.state.customerId}
                    />
                    <MDBInput className='mb-4'
                              label='Full Name'
                              type='text'
                              placeholder="Full Name"
                              name="fullName"
                              value={this.state.fullName}
                              onChange={this.changeHandler}
                    />
                    <MDBInput className='mb-4'
                              type='text'
                              label='Phone #'
                              placeholder='Phone #'
                              name="phone"
                              value={this.state.phone}
                              onChange={this.changeHandler}
                    />
                    <MDBInput className='mb-4'
                              type='text'
                              label='SSN'
                              placeholder='Social Security #'
                              name="ssn"
                              value={this.state.ssn}
                              onChange={this.changeHandler}
                    />
                    <MDBInput className='mb-4'
                              type='text'
                              label='State ID'
                              placeholder='stateID'
                              name="stateID"
                              value={this.state.stateID}
                              onChange={this.changeHandler}
                    />
                    <select
                        className="form-select mb-4"
                        aria-label="Security Questions"
                        name="secretQuestion"
                        onChange={this.changeHandler}
                        value={this.state.secretQuestion}>
                        <option selected>Select Security Question</option>
                        <option value="Favorite Actor / Actress">Favorite Actor / Actress</option>
                        <option value="Name of first pet">Name of first pet</option>
                        <option value="Mother's Maiden Name">Mother's Maiden Name</option>
                    </select>
                    <MDBInput className='mb-4'
                              type='password'
                              label='Enter Answer'
                              onChange={this.changeHandler}
                              name="secretAnswer"
                              value={this.state.secretAnswer}
                    />
                    <MDBBtn type='submit' className='mb-4'>
                        Update
                    </MDBBtn>
                </form>
            </div>
        );
    }
}

export default Profile;