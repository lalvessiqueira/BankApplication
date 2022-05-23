import React, {Component} from 'react';
import {MDBBtn, MDBCheckbox, MDBCol, MDBInput, MDBRow} from "mdb-react-ui-kit";

class ForgotPassword extends Component {
    render() {
        return (
            <div className="container rounded-3" id='bg-glass'>
                <form>
                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <MDBInput className='mt-4' label='Enter Username' />
                        </MDBCol>
                    </MDBRow>

                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <select className="form-select" aria-label="Security Questions">
                                <option selected>Security Questions</option>
                                <option value="1">Favorite Actor / Actress</option>
                                <option value="2">Name of first pet</option>
                                <option value="3">Mother's Maiden Name</option>
                            </select>
                        </MDBCol>
                    </MDBRow>

                    <MDBInput wrapperClass='mb-4' type='text' label='Enter Answer' />

                    <MDBBtn className='mb-4' type='submit'>
                        Submit
                    </MDBBtn>

                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <p color='black'>Already have a Customer account? <a href='#!'>Login here</a></p>
                        </MDBCol>
                    </MDBRow>
                </form>
            </div>
        );
    }
}

export default ForgotPassword;