'use strict';

class ViewEvents extends React.Component {

    handleAlert = () => {
        alert("Something bad happened :(");
    };

    render() {
        if (!(Array.isArray(this.props.ticketList) && this.props.ticketList.length > 0)) {
            return (
                <div>
                    <button name="home"
                        style={{ backgroundColor: "red"}}
                        onClick={(e) => this.props.onNavigate(e)}>Back</button><br></br>
                    <p style={{ color: "white", border: "solid black", backgroundColor: "#085394", fontSize: "30px" }}>No Events :(</p>
                    <button name= "create" onClick={(e) => this.props.onNavigate(e)} 
                        style={{ backgroundColor: this.props.color, width: "100px", height: "50px", margin: "10px" }}>Create Event</button>
                </div>
            );
        } else {
            return (
                <div>
                    <button name="home"
                        style={{ backgroundColor: "red"}}
                        onClick={(e) => this.props.onNavigate(e)}>Back</button><br></br>
                    <p style={{ color: "white", border: "solid black", backgroundColor: "#085394", fontSize: "30px" }}>All your Events: </p>
                    <table>
                        <tbody>
                            {this.props.ticketList.map((element, index) => (
                                <tr key={index} style={{ border: '5px solid' }}>
                                    <td>
                                        {element}
                                    </td>
                                    <td>
                                        <button onClick={this.handleAlert()}>Modify</button>
                                        <button onClick={this.handleAlert()}>Delete</button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                    <button onClick={this.handleAlert} 
                        style={{ backgroundColor: this.props.color, width: "100px", height: "50px", margin: "10px" }}>Create Event</button>
                </div>
            );
        }
    }
}