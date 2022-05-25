import React, {Component} from "react";
import CreateAccount from "./CreateAccount";
import AddBeneficiary from "./AddBeneficiary";

class CustomerFunctions extends Component {
    constructor(props) {
        super(props);
        // window.localStorage.setItem("username", null)
        this.state = {
            // isLoggedIn: window.localStorage.getItem("username") === null
            view: 0
        };
    }
    render() {
        return (
            <div className="col-md-6 mb-3">
                <button className="button" onClick={() => this.setState({view: 1})}>Button 1</button>
                <button className="button" onClick={() => this.setState({view: 2})}>Button 2</button>
                <button className="button">Button 3</button>
                {this.state.view === 1 ? <CreateAccount/> : ''}
                {/*{this.state.view === 2 ? <AddBeneficiary/> : ''}*/}
                {/*{this.state.view === 2 ? <AddBeneficiary/> : ''}*/}
                {/*<View3></View3>*/}
            </div>
        )
    }
}

export default CustomerFunctions;