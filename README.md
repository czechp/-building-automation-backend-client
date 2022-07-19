# BUILDING AUTOMATION CLIENT BY *PCzech*

Client application for building automation (target device is Raspberry Pi).
Responsibilities of app is:

- communication with [backend system](https://github.com/czechp/building-automation-backend),
- control GPIO pin in order to manage connected devices

## TODO

### Client configuration:

- [x] ClientConfiguration domain,
- [x] useCase assign authorization token,
- [ ] security (external userDetailsService),
- [ ] set name,
- [ ] useCase assign location id,
- [ ] useCase client living notify,