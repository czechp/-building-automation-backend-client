# BUILDING AUTOMATION CLIENT BY *PCzech*

Client application for building automation (target device is Raspberry Pi).
Responsibilities of app is:

- communication with [backend system](https://github.com/czechp/building-automation-backend),
- control GPIO pin in order to manage connected devices

## TODO

### Client configuration:

- [x] ClientConfiguration domain,
- [x] useCase assign authorization token,
- [x] security (external userDetailsService),
- [ ] set name,

#### Use case assign location id:
- [ ] query to getting all unassigned locations,
- [ ] use case to assign and unassigned location id,
- [ ] when unassigned clear all gpio bindings with devices,  
