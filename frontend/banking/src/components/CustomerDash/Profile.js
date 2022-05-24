import React, {Component} from 'react';

class Profile extends Component {
    render() {
        return (
            <div className='container mt-3 rounded-3' id='bg-glass'>
                <form className="row g-3">
                    <div className="col-md-3">
                        <label className="form-label">Customer ID</label>
                        <input type="email" className="form-control"/>
                    </div>
                    <div className="col-md-6">
                        <label className="form-label">Full Name</label>
                        <input type="password" className="form-control"/>
                    </div>
                    <div className="col-12">
                        <label className="form-label">Address</label>
                        <input type="text" className="form-control"placeholder="1234 Main St"/>
                    </div>
                    <div className="col-12">
                        <label className="form-label">Address 2</label>
                        <input type="text" className="form-control"
                               placeholder="Apartment, studio, or floor"/>
                    </div>
                    <div className="col-md-6">
                        <label htmlFor="inputCity" className="form-label">City</label>
                        <input type="text" className="form-control" id="inputCity"/>
                    </div>
                    <div className="col-md-4">
                        <label htmlFor="inputState" className="form-label">State</label>
                        <select id="inputState" className="form-select">
                            <option selected>Choose...</option>
                            <option>...</option>
                        </select>
                    </div>
                    <div className="col-md-2">
                        <label htmlFor="inputZip" className="form-label">Zip</label>
                        <input type="text" className="form-control" id="inputZip"/>
                    </div>
                    <div className="col-12">
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" id="gridCheck"/>
                                <label className="form-check-label" htmlFor="gridCheck">
                                    Check me out
                                </label>
                        </div>
                    </div>
                    <div className="mb-3">
                        <button type="submit" className="btn btn-primary">Sign in</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default Profile;