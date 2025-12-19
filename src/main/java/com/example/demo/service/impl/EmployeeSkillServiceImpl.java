@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill skill) {
        return repository.save(skill);
    }

    @Override
    public EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill skill) {
        skill.setId(id);
        return repository.save(skill);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return repository.findBySkillId(skillId);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill es = repository.findById(id).orElseThrow();
        es.setActive(false);
        repository.save(es);
    }
}
