import React, {Component} from 'react';
import {MDBBtn, MDBInput} from "mdb-react-ui-kit";
import './Profile.css';

class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            fullName: "",
            customerId: "",
            phone: 0,
            secretQuestion: "",
            secretAnswer: "",
            stateID: null,
            ssn: null
        };
    }

    render() {
        return (
            <div className='container rounded-3' id='bg-glass'>
                <form className='py-2'>
                    <MDBInput className='mb-4' style={{color: 'black'}}
                        label='Customer ID'
                        placeholder='hb_123456'
                        readonly

                    />
                    <MDBInput className='mb-4' type='text' label='Full Name' />
                    <MDBInput className='mb-4' type='text' label='Phone #' />
                    <MDBInput className='mb-4' type='text' label='Social Security #' />
                    <MDBInput className='mb-4' type='text' label='State ID' />
                    <select
                        className="form-select mb-4"
                        aria-label="Security Questions"
                        name="secQuestion">
                        <option selected>Select Security Question</option>
                        <option value="Favorite Actor / Actress">Favorite Actor / Actress</option>
                        <option value="Name of first pet">Name of first pet</option>
                        <option value="Mother's Maiden Name">Mother's Maiden Name</option>
                    </select>
                    <MDBInput className='mb-4' type='text' label='Enter Answer' />
                    <MDBBtn type='submit' className='mb-4'>
                        Update
                    </MDBBtn>
                </form>
            </div>
        );
    }
}

export default Profile;